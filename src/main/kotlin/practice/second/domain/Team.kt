package practice.second.domain

import javax.persistence.*

@Entity
data class Team (
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    val id: Long = 0,

    @OneToMany(mappedBy = "team")
    val members: MutableList<Member> = ArrayList(),

    @Column(name = "NAME")
    var name: String = ""
) {
    fun addMember(member: Member) {
        member.team = this
        members.add(member)
    }
}