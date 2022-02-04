package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Test;

class TestTileShouldNotGenerateException
{
    @Test
    void testTileShouldNotGenerateException()
    {
        TileShouldNotGenerateException tsnge = new TileShouldNotGenerateException("Nope");
    }
}
