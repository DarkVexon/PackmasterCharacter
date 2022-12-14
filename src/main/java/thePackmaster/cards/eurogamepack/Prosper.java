package thePackmaster.cards.eurogamepack;


import com.megacrit.cardcrawl.actions.watcher.SkipEnemiesTurnAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.stances.eurogamepack.VictoryStance;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.SpireAnniversary5Mod.modID;

public class Prosper extends AbstractVPCard{
    public static final String ID = makeID("Prosper");

    public Prosper() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;

    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SkipEnemiesTurnAction());
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        if (p.stance.ID.equals(new VictoryStance().ID)) {
            return super.canUse(p, m);
        } else {
            this.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
            return false;
        }
    }

    public void upp() {
        upgradeBaseCost(2);
    }
}
