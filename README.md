lol-client-java-api
----------

Simple library which provides access to internal League of Legends Client API.

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.

## Requirements

**lol-client-java-api** requires Java 8 and depends on Google GSON.

## Usage

This library depends on League of Legends client and requires it to be open while using this API.

```java
import generated.LolChampionsCollectionsChampion;
import generated.LolChampionsCollectionsChampionSkin;
import generated.Summoner;
import lolclient.ClientApi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SkinListExample {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Simple example, which show all owned champions and skins (with purchase date)
     */
    public static void main(String[] args) throws IOException {
        //Initialize API
        ClientApi api = new ClientApi();
        //Check if user is logged in
        if (!api.isAuthorized()) {
            System.out.println("Not logged in!");
            return;
        }
        //Get current summoner
        Summoner summoner = api.getCurrentSummoner();
        //Get champion collection of summoner
        LolChampionsCollectionsChampion[] champions = api.getChampions(summoner.summonerId);
        for (LolChampionsCollectionsChampion champion : champions) {
            if (champion.ownership.owned) {
                System.out.println(champion.name + " purchased on " + FORMATTER.format(new Date(champion.ownership.rental.purchaseDate)));
                for (LolChampionsCollectionsChampionSkin skin : champion.skins) {
                    if (!skin.isBase && skin.ownership.owned) {
                        System.out.println("\t" + skin.name + " purchased on " + FORMATTER.format(new Date(skin.ownership.rental.purchaseDate)));
                    }
                }
            }
        }
    }
}
```

This library is still under development and lacks many features. Right now to access them, use these methods.

```java
import generated.LolChatUserResource;
import lolclient.ClientApi;

import java.io.IOException;

public class DirectAccessExample {

    /**
     * Simple example, which shows how to access API directly
     */
    public static void main(String[] args) throws IOException {
        //Initialize API
        ClientApi api = new ClientApi();
        //Get current user chat info
        LolChatUserResource user = api.executeGet("/lol-chat/v1/me", LolChatUserResource.class);
        //Print status message
        System.out.println(user.statusMessage);
    }
}

```

All possible paths can be found in ```api.getSwaggerJson()``` or ```api.getOpenapiJson()```.

All classes in ```generated``` package were generated from OpenAPI JSON.

All examples are in ```examples``` package.

## Contributing
All contributions are appreciated.
If you would like to contribute to this project, please send a pull request.

## Contact
Have a suggestion, complaint, or question? Open an [issue](https://github.com/stirante/lol-client-java-api/issues).