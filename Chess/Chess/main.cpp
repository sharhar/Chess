#include <SFML/Graphics.hpp>

int main() {
	sf::RenderWindow window(sf::VideoMode(800, 600), "SFML Window!");

	while (window.isOpen()) {
		window.clear();

		sf::Event event;
		while (window.pollEvent(event)) {
			switch (event.type) {
				case(sf::Event::Closed) : {
					window.close();
				}
			}
		}

		window.display();
	}

	return 0;
}