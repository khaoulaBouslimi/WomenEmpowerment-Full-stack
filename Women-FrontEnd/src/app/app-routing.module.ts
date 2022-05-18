import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BlogComponent } from './blog/blog.component';
import { ComplaintsDetailsComponent } from './complaints-details/complaints-details.component';
import { ComplaintsListComponent } from './complaints-list/complaints-list.component';
import { CreateAnswerComponent } from './create-answer/create-answer.component';
import { CreateComplaintsComponent } from './create-complaints/create-complaints.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { CreateQuizComponent } from './create-quiz/create-quiz.component';
import { CreateTraininsessionComponent } from './create-traininsession/create-traininsession.component';
import { DisplayEventComponent } from './display-event/display-event.component';
import { FacebookLoginComponent } from './facebook-login/facebook-login.component';

import { HomeComponent } from './home/home.component';
import { JobOfferDetailsComponent } from './job-offer-details/job-offer-details.component';
import { JobOfferListComponent } from './job-offer-list/job-offer-list.component';
import { ListAnswerComponent } from './list-answer/list-answer.component';
import { LoginComponent } from './login/login.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { QuestionComponent } from './question/question.component';
import { QuizListComponent } from './quiz-list/quiz-list.component';
import { RegisterComponent } from './register/register.component';
import { SingleBlogComponent } from './single-blog/single-blog.component';
import { TrainingSessionListComponent } from './training-session-list/training-session-list.component';
import { UpdateAnswerComponent } from './update-answer/update-answer.component';
import { UpdateComplaintsComponent } from './update-complaints/update-complaints.component';
import { UpdateJobOfferComponent } from './update-job-offer/update-job-offer.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { UpdateQuizComponent } from './update-quiz/update-quiz.component';
import { UpdateTraininsessionComponent } from './update-traininsession/update-traininsession.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { WelcomeQuizComponent } from './welcome-quiz/welcome-quiz.component';

const routes: Routes = [
  { path: '', component:HomeComponent },
  { path: 'complaintsList', component: ComplaintsListComponent },
  { path: 'complaint/:id', component: ComplaintsDetailsComponent },
  { path: 'createComplaints', component:CreateComplaintsComponent },
  { path: 'login', component:LoginComponent },
  { path: 'register', component:RegisterComponent },
  { path: 'update', component:UpdateComplaintsComponent },

  {path: "trainingSessionList" , component: TrainingSessionListComponent },
  {path: "create-ts" , component: CreateTraininsessionComponent },
  {path: "update-ts/:id" , component: UpdateTraininsessionComponent },


  {path: "welcomeToQuiz" , component: WelcomeQuizComponent },
  
  {path:'event',component:DisplayEventComponent},


  {path: "quiz" , component: QuestionComponent },
  {path: "quizList" , component: QuizListComponent },
  {path: "create-quiz" , component: CreateQuizComponent },
  {path: "update-quiz/:id" , component: UpdateQuizComponent },


  {path: "questionList" , component: QuestionListComponent },
  {path: "create-question/:id" , component: CreateQuestionComponent },
  {path: "update-question/:id" , component: UpdateQuestionComponent },


  {path: "answerList" , component: ListAnswerComponent },
  {path: "create-answer/:id" , component: CreateAnswerComponent },
  {path: "update-answer/:id" , component: UpdateAnswerComponent },
  {path: 'FbLogin' , component: FacebookLoginComponent },
  {path: 'jobOffers', component: JobOfferListComponent},
  {path: 'create-job-offer', component: CreateJobOfferComponent},
  {path: '', redirectTo: 'jobOffers', pathMatch: 'full'},
  {path: 'update-job-offer/:idOffer', component: UpdateJobOfferComponent},
  {path: 'job-offer-details/:idOffer', component: JobOfferDetailsComponent},
  {path: 'blog', component: BlogComponent},
  { path: 'blog-post/:id', component: SingleBlogComponent },

  { path: 'create-post', component: CreatePostComponent },
  { path: 'about', component: AboutComponent },
  { path: 'user-profile/:id', component: UserProfileComponent },
  { path: 'update-user/:id', component: UpdateUserComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
