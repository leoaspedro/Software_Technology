import { RandomUtils } from './randomUtils';

export class UserUtils {
  private static instance: UserUtils;
  private constructor() {
    this.registrationData.email = RandomUtils.getRandomEmail();
  }
  private registrationData = {
    name: 'John Smith',
    address: '12A Vallgatan',
    city: 'Vaxjo',
    zipCode: 35235,
    country: 'Sweden',
    email: '',
    password: 'Password1$',
  };
  static getInstance(): UserUtils {
    if (!UserUtils.instance) {
      UserUtils.instance = new UserUtils();
    }
    return UserUtils.instance;
  }
  public get RegistrationData() {
    return this.registrationData;
  }
}
