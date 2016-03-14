package impl

import spock.lang.Specification
import spock.util.environment.RestoreSystemProperties

/**
 * Created by erickpr on 01/03/16.
 */
class SysSpec extends Specification {

    @RestoreSystemProperties
    def "first method adds a java system property"() {
        setup:
        System.properties['spockAdded'] = 'Spock até que funfa'

        expect:
        System.properties['spockAdded'] == 'Spock até que funfa'
    }

    def "second method has no acess to the new property"() {
        expect:
        !System.properties['spockAdded']
    }
}


