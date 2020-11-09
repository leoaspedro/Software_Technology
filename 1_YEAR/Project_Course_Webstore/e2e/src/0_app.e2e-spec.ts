import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('Main App Test', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
    browser.waitForAngularEnabled(false);
  });
  it('should be at the bikeshop homepage', () => {
    page.navigateTo();
    expect(page.getPageTitle()).toEqual('Startpage | Bikeshop');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser
      .manage()
      .logs()
      .get(logging.Type.BROWSER);
    expect(logs).not.toContain(
      jasmine.objectContaining({
        level: logging.Level.SEVERE,
      } as logging.Entry)
    );
  });
});
