package pblproj.pblschedule.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pblproj.pblschedule.entities.Group
import pblproj.pblschedule.services.GroupService

@RestController
class BaseController @Autowired constructor(val groupService: GroupService) {

    @GetMapping("/groups")
    fun getGroups(): List<Group> = groupService.getAllGroups()

    @GetMapping("/hello")
    fun hello(): String = "Hello"
}