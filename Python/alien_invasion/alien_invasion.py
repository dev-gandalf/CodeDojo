import sys
import pygame
from settings import Settings
from ship import Ship



class AlienInvasion:
    """Overall class to manage game assets and behavior."""
    def __init__(self):
        """Initialize the game and create game resources."""

        pygame.init()
        pygame.display.set_caption("Alien Invasion")
        self.settings = Settings()

        self.screen = pygame.display.set_mode(
                        (self.settings.screen_width,
                         self.settings.screen_height))

        self.ship = Ship(self)
        self.clock = pygame.time.Clock()



    def run_game(self):

        # watch for keyboard and mouse events.
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()

            # Redraw the screen during each pass through the loop. 
            self.screen.fill(self.settings.bg_color)
            self.ship.blitme()

            # Make the most recently drawn screen visible.
            pygame.display.flip()

            self.clock.tick(60)





if __name__ == '__main__':

    # Make a game instance and run game.
    ai = AlienInvasion()
    ai.run_game()

