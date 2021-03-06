package generated;

import java.util.Map;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LolLobbyPartyDto {

	public LolLobbyQueueRestrictionDto activeRestrictions;
	public Boolean activityLocked;
	public Long activityResumeUtcMillis;
	public Long activityStartedUtcMillis;
	public LolLobbyPartyChatDto chat;
	public LolLobbyGameModeDto gameMode;
	public Integer maxPartySize;
	public String partyId;
	public String partyType;
	public String platformId;
	public List<LolLobbyPartyMemberDto> players;
	public Long version;

}