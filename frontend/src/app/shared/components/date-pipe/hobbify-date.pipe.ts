import {Inject, inject, LOCALE_ID, Pipe, PipeTransform} from '@angular/core';
import {formatDate} from '@angular/common';

@Pipe({
    name: 'hobbifyDate'
})
export class HobbifyDatePipe implements PipeTransform {

    format = 'dd MMM HH:mm';

    constructor(@Inject(LOCALE_ID) private locale: string) {}

    transform(value: any, locale?: string): any {
        if (value == null || value === '' || value !== value) return null;

        try {
            return formatDate(value, this.format, locale || this.locale);
        } catch (error) {
            throw new Error(error.message);

        }
    }
}
