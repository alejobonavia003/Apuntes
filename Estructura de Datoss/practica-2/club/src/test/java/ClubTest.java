

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test class ClubTest.
 */
public class ClubTest
{
    @Test
    public void testJoin()
    {
        Club club2 = new Club();
        Membership membersh2 = new Membership("Dijkstra", 4, 1972);
        club2.join(membersh2);
        assertEquals(1, club2.numberOfMembers());
    }
   
    @Test
    public void testJoinedInMonth()
    {
        Club club2 = new Club();
        Membership membersh2 = new Membership("Dijkstra", 4, 1972);
        club2.join(new Membership("Turing", 4, 1948));
        club2.join(new Membership("Liskov", 1, 1948));
        club2.join(membersh2);
        assertEquals(2, club2.joinedInMonth(4));
    }
  
      
    @Test
    public void testPurge()
    {
        Club club2 = new Club();
        club2.join(new Membership("Dijkstra", 4, 1972));
        club2.join(new Membership("Turing", 1, 1972));
        int numberBefore = club2.numberOfMembers();
        club2.purge(1,1972);
        assertEquals(numberBefore - 1, club2.numberOfMembers());
    }

    @Test
    public void testPurge1()
    {
        Club club2 = new Club();
        club2.join(new Membership("Dijkstra", 1, 1972));
        club2.join(new Membership("Turing", 1, 1972));
        club2.purge(1,1972);
        assertEquals(0,club2.numberOfMembers());
    }
 }

