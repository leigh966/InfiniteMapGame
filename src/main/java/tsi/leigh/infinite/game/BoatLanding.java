package tsi.leigh.infinite.game;

public class BoatLanding extends Shore
{
        public BoatLanding()
        {
            entryString = "Landed onshore";
            returnString = "On the shore with the boat to the west";
        }

        // stub
        public Tile GenerateTile()
        {
            return new Beach();
        }
}
