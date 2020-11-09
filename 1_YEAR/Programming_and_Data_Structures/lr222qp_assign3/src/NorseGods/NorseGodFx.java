package NorseGods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class NorseGodFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();

        ArrayList<NorseGods> listeNorse = new ArrayList<>();
        listeNorse.add(new NorseGods("Ymir","Giant","In Norse mythology, Ymir (/ˈiːmɪər/),[1] Aurgelmir, Brimir, or Bláinn is the ancestor of all jötnar. Ymir is attested in the Poetic Edda, compiled in the 13th century from earlier traditional material, in the Prose Edda, written by Snorri Sturluson in the 13th century, and in the poetry of skalds. Taken together, " +
                "several stanzas from four poems collected in the Poetic Edda refer to Ymir as a primeval being who was born from venom that dripped from the icy rivers Élivágar and lived in the grassless void of Ginnungagap. Ymir birthed a male and female from the pits of his arms, " +
                "and his legs together begat a six-headed being. The gods Odin, Vili and Vé fashioned the Earth (elsewhere personified as a goddess; Jörð) from his flesh, from his blood the ocean, from his bones the mountains, from his hair the trees, from his brains the clouds, from his skull the heavens, " +
                "and from his eyebrows the middle realm in " +
                "which mankind lives, Midgard. In addition, one stanza relates that the dwarfs were given life by the gods from Ymir's " +
                "flesh and blood (or the Earth and sea).\n" +
                "\n" +
                "In the Prose Edda, a narrative is provided that draws from, adds to, and differs from the accounts in the Poetic Edda. According to the Prose Edda, after Ymir was formed from the" +
                " elemental drops, so too was Auðumbla, a primeval cow, whose milk Ymir fed from. The Prose Edda also states that three gods killed Ymir; the brothers Odin, Vili and Vé, and details that, upon Ymir's death, his blood caused an" +
                " immense flood. Scholars have debated as to what extent Snorri's account of Ymir is an attempt to synthesize a coherent narrative for the purpose of the Prose Edda and " +
                "to what extent Snorri drew from traditional material outside of the corpus that he cites. By way of historical linguistics and comparative " +
                "mythology, scholars have linked Ymir to Tuisto, the Proto-Germanic being attested by Tacitus in his 1st century AD work Germania and have identified Ymir as an echo of a primordial being reconstructed in Proto-Indo-European mythology"));
        listeNorse.add(new NorseGods("Odin","Æsir","In Germanic mythology, Odin (/ˈoʊdɪn/;[1] from Old Norse: Óðinn, IPA: [ˈoːðinː]) is a widely revered god. In Norse mythology, from which stems most surviving information " +
                "about the god, Odin is associated with wisdom, healing, death, royalty, the gallows, knowledge, battle, sorcery, poetry, frenzy, and the runic alphabet, and is the husband of the goddess Frigg. In wider Germanic mythology and paganism, Odin was " +
                "known in Old English as Wōden, in Old Saxon as Wōdan, and in Old High German as Wuotan or Wōtan, all stemming from the reconstructed Proto-Germanic theonym *wōđanaz.\n" +
                "\n" +
                "Odin is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman " +
                "occupation of regions of Germania through the tribal expansions of the Migration Period and the Viking Age. In the modern period, Odin continued to be acknowledged in the rural folklore of Germanic Europe. " +
                "References to Odin appear in place names throughout  regions historically inhabited by the ancient Germanic peoples, and the day of the week Wednesday bears his name in many Germanic languages, including English."));
        listeNorse.add(new NorseGods("Frigg","Æsir","In Germanic mythology, Frigg (/frɪɡ/;[1] Old Norse), Frija (Old High German), Frea (Langobardic), and Frige (Old English) is a goddess. In nearly all sources, she is described as the wife of the god Odin. In Old High German and Old Norse sources, she is also connected with the goddess Fulla. The English weekday name Friday (etymologically Old English \"Frīge's day\") bears her name.\n" +
                "\n" +
                "Frigg is described as a goddess associated with foresight and wisdom in Norse mythology, the northernmost branch of Germanic mythology and most extensively attested. Frigg is the wife of the major god Odin and dwells in the wetland halls of Fensalir, is famous for her foreknowledge, is associated with the goddesses Fulla, Lofn, Hlín, and Gná, and is ambiguously associated with the Earth, otherwise personified as an apparently separate entity Jörð (Old Norse \"Earth\"). The children of Frigg and Odin include the gleaming god Baldr. Due to the significant thematic overlap, scholars have proposed a particular connection to the goddess Freyja.\n" +
                "\n" +
                "After Christianization, the mention of Frigg continued to occur in Scandinavian folklore. In modern times, Frigg has appeared in modern popular culture, has been the subject of art and receives modern veneration in Germanic Neopaganism."));
        listeNorse.add(new NorseGods("Thor","Æsir","In Germanic mythology, Thor (/θɔːr/; from Old Norse: Þórr) is a hammer-wielding god associated with thunder, lightning, storms, oak trees, strength, the protection of mankind, and also hallowing and fertility. Besides Old Norse Þórr, extensions of the god occur in Old English as Þunor, and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ). All forms of the deity stem from a Common Germanic *Þunraz (meaning 'thunder').\n" +
                "\n" +
                "Thor is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania, to the tribal expansions of the Migration Period, to his high popularity during the Viking Age, when, in the face of the process of the Christianization of Scandinavia, emblems of his hammer, Mjölnir, were worn and Norse pagan personal names containing the name of the god bear witness to his popularity."));
        listeNorse.add(new NorseGods("Balder","Æsir","Baldr (also Balder, Baldur) is a god in Norse mythology, and a son of the god Odin and the goddess Frigg. He has numerous brothers, such as Thor and Váli.\n" +
                "\n" +
                "In the 12th century, Danish accounts by Saxo Grammaticus and other Danish Latin chroniclers recorded a euhemerized account of his story. Compiled in Iceland in the 13th century, but based on much older Old Norse poetry, the Poetic Edda and the Prose Edda contain numerous references to the death of Baldr as both a great tragedy to the Æsir and a harbinger of Ragnarök.\n" +
                "\n" +
                "According to Gylfaginning, a book of Snorri Sturluson's Prose Edda, Baldr's wife is Nanna and their son is Forseti. In Gylfaginning, Snorri relates that Baldr had the greatest ship to ever be built, named Hringhorni, and that there is no place more beautiful than his hall, Breidablik."));
        listeNorse.add(new NorseGods("Tyr","Giant","In Germanic mythology, Týr (Old Norse), Tíw (Old English), and Ziu (Old High German) is a god. Stemming from the Proto-Germanic deity *Tīwaz and ultimately from the Proto-Indo-European deity *Dyeus, little information about the god survives beyond Old Norse sources. Due to the etymology of the god's name and the shadowy presence of the god in the extant Germanic corpus, some scholars propose that Týr may have once held a more central place among the deities of early Germanic mythology."));
        listeNorse.add(new NorseGods("Bragi","Skaldic","Bragi is the skaldic god of poetry in Norse mythology. Bragi is generally associated with bragr, the Norse word for poetry. The name of the god may have been derived from bragr, or the term bragr may have been formed to describe 'what Bragi does'. A connection between the name Bragi and Old English brego 'chieftain' has been suggested but is generally now discounted. A connection between Bragi and the bragarfull 'promise cup' is sometimes suggested, as bragafull, an alternate form of the word, might be translated as 'Bragi's cup'."));
        listeNorse.add(new NorseGods("Loki","Giant","Loki (Old Norse: [ˈloki], Modern Icelandic: [ˈlɔːkɪ], often Anglicized as /ˈloʊki/) is a god in Norse mythology. Loki is in some sources the son of Fárbauti and Laufey, and the brother of Helblindi and Býleistr. By the jötunn Angrboða, Loki is the father of Hel, the wolf Fenrir, and the world serpent Jörmungandr. By his wife Sigyn, Loki is the father of Narfi and/or Nari. By the stallion Svaðilfari, Loki is the mother—giving birth in the form of a mare—to the eight-legged horse Sleipnir. In addition, Loki is referred to as the father of Váli in Prose Edda, though this source also refers to Odin as the father of Váli twice, and Váli is found mentioned as a Son of Loki only once."));

        ListView<String> listNorse = new ListView<>();
        listNorse.setPrefWidth(150);
        for(int i =0;i<listeNorse.size();i++){
            listNorse.getItems().add(listeNorse.get(i).getName());
        }

        Text title = new Text("Norse Gods and other Beings");
        title.setFont(Font.font("Arial", FontWeight.BOLD,25));
        BorderPane.setMargin(title, new Insets(5,5,5,5));
        BorderPane.setMargin(listNorse, new Insets(5,5,5,5));
        bp.setTop(title);
        bp.setLeft(listNorse);

        listNorse.setOnMouseClicked(event -> {

            int pos = listNorse.getSelectionModel().getSelectedIndex();
            Text race = new Text("\n"+listeNorse.get(pos).getRace());
            race.setFont(Font.font("Arial", FontPosture.ITALIC,13));
            Text name = new Text(listeNorse.get(pos).getName());
            name.setFont(Font.font("Arial", FontWeight.BOLD,20));
            Text desc = new Text("\n\n\n\n"+listeNorse.get(pos).getDesc());
            TextFlow tf = new TextFlow(name,race,desc);
            tf.setMinHeight(600);
            tf.setMaxWidth(500);
            tf.setMinWidth(500);
            tf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT)));
            ScrollPane sP = new ScrollPane(tf);

            bp.setCenter(sP);
            BorderPane.setMargin(sP, new Insets(5,17,5,5));

        });





        //bp.getChildren().addAll(name,race,desc,tx,listNorse);


        //DISPLAY

        Scene scene = new Scene(bp, 700,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Norse Gods");
        primaryStage.show();
    }
}
