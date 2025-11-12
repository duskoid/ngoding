import java.util.*;

public class GameTeam implements Team {

    private String teamName;

    // TODO: Gunakan List untuk menyimpan urutan anggota team
    private List<TeamMember> members;

    // TODO: Gunakan Map untuk quick lookup member berdasarkan nama
    private Map<String, TeamMember> memberMap;

    public GameTeam(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.memberMap = new HashMap<>();
    }

    // TODO: Implement addMember
    // Tambahkan member ke List dan Map
    // Tambahkan role "Player" ke Set
    public void addMember(TeamMember member) {
        members.add((Player) member);
        memberMap.put(member.getName(), member);
    }

    // TODO: Implement removeMember
    // Cari dan hapus member dari List menggunakan iterator
    // Hapus dari Map juga
    public void removeMember(String memberName) {
        for (TeamMember t : members) {
            if (t.getName().equalsIgnoreCase(memberName)) {
                members.remove(t);
                memberMap.remove(memberName, t);
            }
        }
    }

    // TODO: Implement findMember
    // Gunakan Map untuk quick lookup
    public TeamMember findMember(String memberName) {
        return memberMap.get(memberName);
    }

    // TODO: Buat method getAllMembers() return List<TeamMember>
    public List<TeamMember> getAllMembers() {
        return new ArrayList<>(memberMap.values());
    }

    // TODO: Buat method getTeamSize() return int
    public int getTeamSize() {
        return memberMap.size();
    }

    // TODO: Buat method getTopSkillPlayer() return TeamMember
    // Loop melalui List dan cari player dengan skill tertinggi
    public TeamMember getTopSkillPlayer() {
        TeamMember topSkillPlayer = null;
        int maxSkill = Integer.MIN_VALUE;

        for (TeamMember member : members) {
            if (member.getSkillLevel() > maxSkill) {
                maxSkill = member.getSkillLevel();
                topSkillPlayer = member;
            }
        }

        return topSkillPlayer;
    }

    // TODO: Buat method getPlayersBySkillLevel(int minSkill) return List<TeamMember>
    // Filter players yang skill-nya >= minSkill
    public List<TeamMember> getPlayersBySkillLevel(int minSkill) {
        List<TeamMember> aboveMin = new ArrayList<>();
        for (TeamMember t : members) {
            if (t.getSkillLevel() >= minSkill) {
                aboveMin.add(t);
            }
        }
        return aboveMin;
    }

    // TODO: Buat method getTeamName() return String
    public String getTeamName() {
        return teamName;
    }
}
