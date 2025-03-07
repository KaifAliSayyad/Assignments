import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'perimeter',
  pure: true,
})
export class PerimeterPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    return (2*Math.PI*value).toFixed(2);
  }

}
