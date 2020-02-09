import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WebApiService } from 'src/app/service/web-api.service';
import { HttpModule, Http } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { TranslateModule, TranslateLoader, TranslateStaticLoader } from 'ng2-translate';
import { ScriptLoaderService } from "src/app/service/ScriptLoaderService";

export function createTranslateLoader(http: Http) {
  return new TranslateStaticLoader(http, './i18n', '.json');
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HttpModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    TranslateModule.forRoot({
      provide: TranslateLoader,
      useFactory: (http: Http) => new TranslateStaticLoader(http, 'i18n', '.json'),
      deps: [Http]
    })

  ],
  exports: [
    TranslateModule
  ],
  providers: [
    WebApiService,
    ScriptLoaderService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
