import SwiftUI

struct ContentView: View {
    private let localPage = Bundle.main.url(forResource: "index", withExtension: "html")

    var body: some View {
        Group {
            if let localPage {
                WebView(url: localPage)
                    .edgesIgnoringSafeArea(.all)
            } else {
                Text("No se encontró el contenido web.")
                    .padding()
            }
        }
    }
}

#Preview {
    ContentView()
}
