import { TestBed } from '@angular/core/testing';

import { GestionarComicService } from './gestionar-comic.service';

describe('GestionarComicService', () => {
  let service: GestionarComicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionarComicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
