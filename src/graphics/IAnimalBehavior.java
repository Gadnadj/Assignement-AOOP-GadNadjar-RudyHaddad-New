package graphics;

/**
 * interface
 */
public interface IAnimalBehavior
{
        /**
         *
         * @return String
         */
        public String getAnimalName();

        /**
         *
         * @return int
         */
        public int getSize();

        /**
         *
         */
        public void eatInc();

        /**
         *
         * @return int
         */
        public int getEatCount();

        /**
         *
         * @return boolean
         */
        public boolean getChanges ();

        /**
         *
         * @param state : state
         */
        public void setChanges (boolean state);
}
