import com.uab.controller.TextController;
import com.uab.model.Composition;
import com.uab.model.Glyph;
import com.uab.model.decorator.BorderDecorator;
import com.uab.model.decorator.ScrollDecorator;
import com.uab.model.strategies.Compositor;
import com.uab.model.strategies.SimpleCompositor;

public class App {
	public static void main(String[] args) {
		Compositor strategy = new SimpleCompositor();
		Glyph glyph = new Composition(strategy);
		// Glyph glyph = new ScrollDecorator(new BorderDecorator(new
		// Composition(
		// strategy), 1), 1);

		TextController textController = new TextController(glyph);
		TextController t2 = new TextController(glyph);

	}
}
