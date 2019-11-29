package pblproj.pblschedule.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import pblproj.pblschedule.entities.Group

@Service
class GroupService @Autowired constructor(val jdbcTemplate: JdbcTemplate) {

    fun getAllGroups(): List<Group> {
        val queryStr = "select * from grupe"
        val resultList: ArrayList<Group> = ArrayList()
        jdbcTemplate.query(queryStr) { resultSet, _ ->
            print(resultSet.getString("name"))

            Group(resultSet.getString(1).toInt(), resultSet.getString(2))
        }.forEach {
            resultList.add(it)
        }

        return resultList
    }
}