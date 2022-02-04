package tsi.leigh.infinite.game;

public class BoatLanding extends Shore
{
        public BoatLanding()
        {
            tileName = "BoatLanding";
            entryString = "Landed onshore";
            returnString = "On the shore with the boat to the west";
        }


        public Tile GenerateTile()
        {
            int currentX = Map.getPosition()[0];
            if(currentX > 1)
            {
                return new Beach();
            }
            else if(currentX == 1)
            {
                return new Shore();
            }
            throw new TileShouldNotGenerateException("Boat should not be generated again!");
        }
}
