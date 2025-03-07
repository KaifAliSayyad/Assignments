import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currencypipe',
  pure: true,
})
export class CurrencyPipe implements PipeTransform {

  transform(value: number, ...args: string[]): string {
    const currencyCode = args[0] || 'USD'; // Default to USD if no currency code provided
    const conversionRates: { [key: string]: number } = {
      USD: 0.013,
      JPY: 110.35,
      SAR: 0.037,
      EUR: 0.011,
      AUD: 0.015
    };



    if (conversionRates[currencyCode]) {
      return `${(value * conversionRates[currencyCode]).toFixed(2)}`;
    } else {
      return 'Invalid currency code';
    }
  }
}
