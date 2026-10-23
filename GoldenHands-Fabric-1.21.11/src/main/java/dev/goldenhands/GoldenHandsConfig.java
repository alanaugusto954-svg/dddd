package dev.goldenhands;

/**
 * Simple source-level settings for the first prototype.
 * Positive X moves a hand outward from the screen center; negative Z moves it farther away.
 */
public final class GoldenHandsConfig {
    private GoldenHandsConfig() {}

    public static final boolean ENABLED = true;

    // Move both hands outward. The mixin flips the X direction per hand.
    public static final float OUTWARD_X = 0.16f;
    public static final float VERTICAL_Y = -0.035f;
    public static final float DEPTH_Z = -0.22f;

    // Scale the rendered first-person hands/items slightly down.
    public static final float SCALE = 0.88f;
}
