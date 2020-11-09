import { browser, logging } from 'protractor';
import { DashboardPage } from './dashboard.po';

describe('Dashboard Component Test', () => {
  let page: DashboardPage;

  beforeEach(() => {
    page = new DashboardPage();
  });

  it('should not allow non-admin to access dashboard', () => {
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
