package graphics;

/**
 * interface
 */
public interface IAnimalBehavior
{
        /**
         *
         * @return String : name of the animal
         */
        public String getAnimalName();

        /**
         *
         * @return int : size of the animal
         */
        public int getSize();

        /**
         *
         */
        public void eatInc();

        /**
         *
         * @return int : counter of eaten animals
         */
        public int getEatCount();

        /**
         *
         * @return boolean : true if the animal mooved
         */
        public boolean getChanges ();

        /**
         *
         * @param state : true if the animal mooved
         */
        public void setChanges (boolean state);
}
