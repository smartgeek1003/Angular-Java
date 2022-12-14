/**
 *    Copyright 2016 Sven Loesekann

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package ch.xxx.trader.adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.xxx.trader.domain.model.entity.QuoteCb;
import ch.xxx.trader.domain.model.entity.QuoteCbSmall;
import ch.xxx.trader.usecase.services.CoinbaseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coinbase")
public class CoinbaseController {
	private final CoinbaseService coinbaseService;
	
	public CoinbaseController(CoinbaseService coinbaseService) {
		this.coinbaseService = coinbaseService;
	}

	@GetMapping("/today")
	public Flux<QuoteCbSmall> todayQuotesBc() {
		return this.coinbaseService.todayQuotesBc();
	}
	
	@GetMapping("/7days")
	public Flux<QuoteCbSmall> sevenDaysQuotesBc() {
		return this.coinbaseService.sevenDaysQuotesBc();
	}
	
	@GetMapping("/30days")
	public Flux<QuoteCbSmall> thirtyDaysQuotesBc() {
		return this.coinbaseService.thirtyDaysQuotesBc();
	}
	
	@GetMapping("/90days")
	public Flux<QuoteCbSmall> nintyDaysQuotesBc() {
		return this.coinbaseService.nintyDaysQuotesBc();
	}

	@GetMapping("/6month")
	public Flux<QuoteCbSmall> sixMonthsQuotesBc() {
		return this.coinbaseService.sixMonthsQuotesBc();
	}
	
	@GetMapping("/1year")
	public Flux<QuoteCbSmall> oneYearQuotesBc() {
		return this.coinbaseService.oneYearQuotesBc();
	}
	
	@GetMapping("/current")
	public Mono<QuoteCb> currentQuoteBc() {
		return this.coinbaseService.currentQuoteBc();
	}	
}
