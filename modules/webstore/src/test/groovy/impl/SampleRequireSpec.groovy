package impl

import spock.lang.IgnoreIf
import spock.lang.Specification

/**
 * Created by erickpr on 01/03/16.
 */
class SampleRequireSpec extends Specification {

    @IgnoreIf({ Boolean.valueOf(properties['spock.ignore.longRunning']) })
    def "run spec if java system property 'spock.ignore.longRunning is not set or false"() {
        expect:
        true
    }

    @IgnoreIf({ javaVersion < 1.7 })
    def "run spec if run in Java 1.7 or higher"() {
        expect:
        true
    }

}
