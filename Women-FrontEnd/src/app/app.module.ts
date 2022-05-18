import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateComplaintsComponent } from './create-complaints/create-complaints.component';
import { ComplaintsDetailsComponent } from './complaints-details/complaints-details.component';
import { ComplaintsListComponent } from './complaints-list/complaints-list.component';
import { UpdateComplaintsComponent } from './update-complaints/update-complaints.component';
import { FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TrainingSessionListComponent } from './training-session-list/training-session-list.component';
import { CreateTraininsessionComponent } from './create-traininsession/create-traininsession.component';
import { UpdateTraininsessionComponent } from './update-traininsession/update-traininsession.component';
import { WelcomeQuizComponent } from './welcome-quiz/welcome-quiz.component';
import { QuestionComponent } from './question/question.component';
import { ChangeBgDirective } from './change-bg.directive';
import { NgxPrintModule } from 'ngx-print';
import { NgxQRCodeModule } from '@techiediaries/ngx-qrcode';
import { QuizListComponent } from './quiz-list/quiz-list.component';
import { CreateQuizComponent } from './create-quiz/create-quiz.component';
import { UpdateQuizComponent } from './update-quiz/update-quiz.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { ListAnswerComponent } from './list-answer/list-answer.component';
import { UpdateAnswerComponent } from './update-answer/update-answer.component';
import { CreateAnswerComponent } from './create-answer/create-answer.component';
import { DisplayEventComponent } from './display-event/display-event.component';


import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxPaginationModule } from 'ngx-pagination';
import { QRCodeModule } from 'angularx-qrcode';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxCaptchaModule } from 'ngx-captcha';
import { FacebookLoginComponent } from './facebook-login/facebook-login.component';
import { FacebookLoginProvider, SocialAuthService, SocialAuthServiceConfig } from 'angularx-social-login';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { JobOfferListComponent } from './job-offer-list/job-offer-list.component';
import { JobOfferDetailsComponent } from './job-offer-details/job-offer-details.component';
import { UpdateJobOfferComponent } from './update-job-offer/update-job-offer.component';
import { BlogComponent } from './blog/blog.component';
import { SingleBlogComponent } from './single-blog/single-blog.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserProfileComponent } from './user-profile/user-profile.component';




@NgModule({
  declarations: [
    AppComponent,
    CreateComplaintsComponent,
    ComplaintsDetailsComponent,
    ComplaintsListComponent,
    UpdateComplaintsComponent,
    
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    TrainingSessionListComponent,
    CreateTraininsessionComponent,
    UpdateTraininsessionComponent,
    WelcomeQuizComponent,
    QuestionComponent,
    ChangeBgDirective,
    QuizListComponent,
    CreateQuizComponent,
    UpdateQuizComponent,
    QuestionListComponent,
    UpdateQuestionComponent,
    CreateQuestionComponent,
    ListAnswerComponent,
    UpdateAnswerComponent,
    CreateAnswerComponent,
    DisplayEventComponent,
    FacebookLoginComponent,
    CreateJobOfferComponent,
    JobOfferListComponent,
    JobOfferDetailsComponent,
    UpdateJobOfferComponent,
    BlogComponent,
    SingleBlogComponent,
    CreatePostComponent,
    ContactComponent,
    AboutComponent,
    UpdateUserComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    NgxPrintModule,
    NgxQRCodeModule,

    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    QRCodeModule,
    NgxCaptchaModule

    
  ],
  providers: [{
    provide: 'SocialAuthServiceConfig',
    useValue: {
      autoLogin: false,
      providers: [
        {
          id: FacebookLoginProvider.PROVIDER_ID,
          provider: new FacebookLoginProvider("721072905994599"),
        },
      ],
      onError: (err) => {
        console.error(err);
      },
    } as SocialAuthServiceConfig,
  },
  SocialAuthService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
