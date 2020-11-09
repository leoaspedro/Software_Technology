import { browser, by, element } from 'protractor';

export class DashboardPage {
  navigateTo() {
    return browser.get(browser.baseUrl + '/dashboard') as Promise<any>;
  }

  getPageTitle() {
    return browser.getTitle() as Promise<any>;
  }
}
