package tsi.leigh.infinite.game;

public class BoatLanding extends Shore
{
        public BoatLanding()
        {
            searchObject = null;
            init();
        }

        public BoatLanding(Collectable c)
        {
            searchObject = c;
            init();
        }

        @Override
        protected void init()
        {
            tileName = "BoatLanding";
            entryString = "Landed onshore";
            returnString = "On the shore with the boat to the west";
            generateSearchString();
        }

        @Override
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
