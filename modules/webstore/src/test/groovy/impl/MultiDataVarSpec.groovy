package impl

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by erickpr on 01/03/16.
 */
class MultiDataVarSpec extends Specification {

    @Unroll("#value as upper case is #expected")
    def "check upper case value of String"() {
        expect:
        value.toUpperCase() == expected

        where:
        [_, value, expected] << [
                [1, 'abc', 'ABC'],
                [2, 'def', 'DEF'],
                [3, '123', '123']
        ]
    }
}
