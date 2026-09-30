import java.util.ArrayList;

public class PackageDatabase {
    private ArrayList<Package> packages;

    public PackageDatabase() {
        packages = new ArrayList<>();
    }

    public int getNumberOfPackages() {
        return packages.size();
    }

    public Package addPackage(Package pack) {
        if (pack == null) {
            return null;
        }

        int position = findPositionOfPackage(pack.getPackageID());

        // Fail if package is already there
        if (position != -1) {
            return null;
        }
        packages.add(pack);
        return pack;
    }

    public int findPositionOfPackage(String packageID) {
        /*
         * for (int i = 0; i < packages.size(); i++) {
         * Package pack = packages.get(i);
         * if (pack.getPackageID().equals(packageID)) {
         * return i;
         * }
         * }
         */

        for (Package p : this.packages) {
            if (packageID.equals(p.getPackageID())) {
                return packages.indexOf(p);
            }
        }
        return -1;
    }

    public Package getPackageByID(String packageID) {
        int position = findPositionOfPackage(packageID);
        if (position == -1) {
            return null;
        }
        return this.packages.get(position);
    }

    public Package getPackageByPosition(int position) {
        if (position < 0 || position >= packages.size()) {
            return null;
        }
        return this.packages.get(position);
    }

    public Package removePackageByID(String packageID) {
        int position = findPositionOfPackage(packageID);
        if (position == -1) {
            return null;
        }
        Package pack = getPackageByPosition(position);
        this.packages.remove(pack);
        return pack;
    }

    public Package removePackageByPosition(int position) {
        if (position < 0 || position >= packages.size()) {
            return null;
        }
        Package pack = getPackageByPosition(position);
        this.packages.remove(pack);
        return pack;
    }
}