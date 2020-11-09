import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { SignService } from './sign.service';

import { FireModule } from '../../modules/fire/fire.module';

describe('LoginRegisterModalService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, FireModule],
    })
  );

  it('should be created', () => {
    const service: SignService = TestBed.get(SignService);
    expect(service).toBeTruthy();
  });
  it('should login succesfully', () => {
    //TODO:Write test case
  });
});
