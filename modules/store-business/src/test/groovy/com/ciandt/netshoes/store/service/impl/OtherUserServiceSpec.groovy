package com.ciandt.netshoes.store.service.impl

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by erickpr on 01/03/16.
 */
class OtherUserServiceSpec extends Specification {

    @Unroll("Expect to count #expectedCount users for following list #userList")
    def "Return total number of users"() {
        setup: 'Create OtherUserServiceImpl instance with users'
        OtherUserServiceImpl userService = new OtherUserServiceImpl(users: userList)

        expect: 'Invoke count() method'
        expectedCount == userService.count();

        where:
        expectedCount | userList
        0             | null
        0             | []
        1             | ["Joãozinho"]
        2             | ["Joãozinho", "Maria"]
    }
}
