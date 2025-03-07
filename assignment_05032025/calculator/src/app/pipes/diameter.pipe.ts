import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'diameter',
  pure: true,
})
export class DiameterPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): number {
    return 2*value;
  }

}
