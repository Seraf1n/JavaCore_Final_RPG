package Characters;

public class SkeletonFactory implements MonsterFactory {
    @Override
    public Character create(int lvlPlayer) {
        return Skeleton.createSkeleton(lvlPlayer);
    }
}