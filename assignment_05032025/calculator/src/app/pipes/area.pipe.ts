import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'area',
  pure: true,
})
export class AreaPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    return (Math.PI*value*value).toFixed(2);
  }

}
