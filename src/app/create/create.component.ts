import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ApiserviceService } from '../apiservice.service';
import { Employees } from '../employee-type';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  // modalExample!: TemplateRef<any>;
  @ViewChild('content', { read: TemplateRef })
  modalExample!: TemplateRef<any>;
  // Raw input
  addFirstNameValue : string = '';
  addLastNameValue : string = '';
  addEmailValue : string = '';
  addEmployeeNumber : number = -1;

  closeResult = ''; //Modal
  employee : Employees = new Employees();
  employees : Employees[] = [];

  constructor(private service:ApiserviceService, private modalService: NgbModal){}




  ngOnInit(): void{
    this.addFirstNameValue = '';
    this.addLastNameValue = '';
    this.addEmailValue = '';
    this.addEmployeeNumber = -1;

    this.employee = new Employees();
    this.getEmployee();
  }
  // (click)="modal.close('Save click')"
  getEmployee(){
    this.service.getallData().subscribe((res)=>{
      this.employees = res;
      console.log("reloaded")
    })
  }

  addEmployee(){
    this.employee.employeeFirstName = this.addFirstNameValue;
    this.employee.employeeLastName = this.addLastNameValue;
    this.employee.employeeEmailAddress = this.addEmailValue;


    this.service.addEmployee(this.employee).subscribe((res)=>{
      console.log(res);
      this.modalService.dismissAll();
      this.ngOnInit();
    })
  }

  deleteEmployee(employeeid : number){
    this.service.deleteEmployee(employeeid).subscribe((res)=>{
      console.log(res);
      this.ngOnInit();
    })
  }

  updateEmployee(){
    if (this.addEmployeeNumber < 0) {
      this.addEmployee();
      return
    }
    this.employee.employeeFirstName = this.addFirstNameValue;
    this.employee.employeeLastName = this.addLastNameValue;
    this.employee.employeeEmailAddress = this.addEmailValue;

    this.service.updateEmployee(this.addEmployeeNumber, this.employee).subscribe((res)=>{
      console.log(res);
      this.modalService.dismissAll();
      this.ngOnInit();
    })
  }

  clickedChangedHandler(clicked: boolean) {
    this.open(this.modalExample, -1);
  }

  // Modal

	open(content: any, employeeid: number) {
    this.addEmployeeNumber = employeeid;
		this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
			(result) => {
				this.closeResult = `Closed with: ${result}`;
			},
			(reason) => {
				this.closeResult = `Dismissed`;
			},
		);
	}

}
