package com.ciandt.netshoes.store.service.impl

import com.ciandt.netshoes.store.domain.Show
import com.ciandt.netshoes.store.service.AgeService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by erickpr on 01/03/16.
 */
class SampleSpec extends Specification {

    ClassUnderTest classUnderTest = new ClassUnderTest();

    @Unroll
    def "Show #name with start time 21h is #expected to show"() {
        setup:
        final AgeService ageService = Mock()
        classUnderTest.ageService = ageService

        when:
        final boolean allowed = classUnderTest.listing(
                new Show(name: name, startTime: 21)
        )

        then:
        1 * ageService.allowedMaxtime(_ as Show) >> { Show show ->
            show.name.toLowerCase().contains('kids') ? 10 : 23
        }

        allowed == expected

        where:
        name            || expected
        'kids rules'    || false
        'Sports united' || true

    }
}
