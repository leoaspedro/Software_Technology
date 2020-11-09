import { AbstractControl, ValidationErrors } from '@angular/forms';

export const PasswordValidator = function(
  control: AbstractControl
): ValidationErrors | null {
  let value: string = control.value || '';

  if (!value) {
    return null;
  }

  // Lowercase, uppercase, number and special character is required
  let upperCaseCharacters: RegExp = /[A-Z]+/g;
  let lowerCaseCharacters: RegExp = /[a-z]+/g;
  let numberCharacters: RegExp = /[0-9]+/g;
  let specialCharacters: RegExp = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;

  // Return an error message if any of the expressions compares to false
  if (
    upperCaseCharacters.test(value) === false ||
    lowerCaseCharacters.test(value) === false ||
    numberCharacters.test(value) === false ||
    specialCharacters.test(value) === false
  ) {
    return {
      passwordStrength: 'Password is not strong enough!',
    };
  }
};
