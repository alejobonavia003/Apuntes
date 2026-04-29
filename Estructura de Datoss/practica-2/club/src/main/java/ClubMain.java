

public class ClubMain {
    public static void main(String[] args) {
        /** 
        Club listClub1 = new Club();
        listClub1.join(new Membership("lauty", 2,2000));
        listClub1.join(new Membership("lauty", 2,2020));
        listClub1.join(new Membership("lauty", 2,2020));
        System.out.println(listClub1.numberOfMembers());
        */

        Club club2 = new Club();
        club2.join(new Membership("Dijkstra", 1, 1972));
        club2.join(new Membership("Turing", 1, 1972));
        System.out.println(club2.purge(1,1972));
        System.out.println(club2.numberOfMembers());
      
    }
}
