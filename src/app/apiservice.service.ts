import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Employees } from './employee-type';
const httpOptions = {
  headers: new HttpHeaders({
    'Accept-Language': 'en',
    'X-Requested-With': 'XMLHttpRequest',
    'Content-Type': 'application/json',
    Accept: 'application/json',
  }),
};
@Injectable({
  providedIn: 'root',
})
export class ApiserviceService {
  constructor(private _http: HttpClient) {}

  apiUrl = 'http://localhost:8082/employees';

  getallData(): Observable<any> {
    return this._http.get(`${this.apiUrl}`, httpOptions);
  }

  addEmployee(employee: Employees): Observable<any> {
    return this._http.post(`${this.apiUrl}`, employee);
  }

  deleteEmployee(employeeid: number): Observable<any> {
    return this._http.delete(`${this.apiUrl}/${employeeid}`, {
      responseType: 'text',
    });
  }

  updateEmployee(employeeid: number, employee: Employees): Observable<any> {
    return this._http.put(`${this.apiUrl}/${employeeid}`, employee);
  }

  parseJwt(token: String) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(
      window
        .atob(base64)
        .split('')
        .map(function (c) {
          return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        })
        .join('')
    );

    return JSON.parse(jsonPayload);
  }
}
