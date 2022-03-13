package edu.wctc.Rooms;

public abstract class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction) {

        switch (direction) {
            case 'n':
                if (north != null) {
                    return north;
                }
                return null;
            case 's':
                if (south != null) {
                    return south;
                }
                return null;
            case 'w':
                if (west != null) {
                    return west;
                }
                return null;
            case 'e':
                if (east != null) {
                    return east;
                }
                return null;
            case 'u':
                if (up != null) {
                    return up;
                }
                return null;
            case 'd':
                if (down != null) {
                    return down;
                }
                return null;
            default:
                return null;
        }

    }

    public String getExits() {
        char[] charExit = new char[]{'n', 's', 'w', 'e', 'u', 'd'};
        String[] stringExit = new String[]{"North", "South", "West", "East", "Up", "Down"};

        String availableExits = "";

        for (int i = 0; i < charExit.length; i++) {
            if (getAdjoiningRoom(charExit[i]) != null) {
                availableExits += stringExit[i] + ", ";
            }
        }
        return availableExits.substring(0, availableExits.trim().length()-1);
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        switch (direction) {
                case 'n':
                    if (north != null) {
                        return true;
                    }
                    return false;
                case 's':
                    if (south != null) {
                        return true;
                    }
                    return false;
                case 'w':
                    if (west != null) {
                        return true;
                    }
                    return false;
                case 'e':
                    if (east != null) {
                        return true;
                    }
                    return false;
                case 'u':
                    if (up != null) {
                        return true;
                    }
                    return false;
                case 'd':
                    if (down != null) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
    }


    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }
}
