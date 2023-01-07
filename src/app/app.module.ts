import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { CreateComponent } from "./create/create.component";
import { ChildComponent } from "./child/child.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { ApiserviceService } from "./apiservice.service";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FormsModule } from "@angular/forms";
import { LoginComponent } from "./login/login.component";
import { SignupComponent } from "./signup/signup.component";
import { LogoutComponent } from "./logout/logout.component";
import { AuthHttpInterceptor, AuthModule } from "@auth0/auth0-angular";

@NgModule({
  declarations: [
    AppComponent,
    CreateComponent,
    ChildComponent,
    LoginComponent,
    SignupComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,

    AuthModule.forRoot({
      domain: "__Auth0_Domain__",
      clientId: "__Auth0_Client_ID__",
      audience: "__Backend_URL__",
      httpInterceptor: {
        allowedList: [`__Backend_URL__/*`],
      },
    }),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthHttpInterceptor,
      multi: true,
    },
    {
      provide: Window,
      useValue: window,
    },
    ApiserviceService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
