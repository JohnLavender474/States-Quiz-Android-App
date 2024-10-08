package edu.uga.cs.csci4830_project4.backend.states;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

import edu.uga.cs.csci4830_project4.backend.contracts.IModel;

/**
 * This class represents a row in the states table.
 */
public class StateModel implements IModel {

    private long id;
    @Nullable
    private String stateName;
    @Nullable
    private String capitalCity;
    @Nullable
    private String secondCity;
    @Nullable
    private String thirdCity;
    @Nullable
    private String statehood;
    @Nullable
    private String capitalSince;
    @Nullable
    private String sizeRank;

    /**
     * Constructs a new StateModel with default values.
     */
    public StateModel() {
        id = -1;
        stateName = null;
        capitalCity = null;
        secondCity = null;
        thirdCity = null;
        statehood = null;
        capitalSince = null;
        sizeRank = null;
    }

    /**
     * Constructs a new {@link StateModel} with the given values contained in the array.
     *
     * @param values the values
     */
    public StateModel(@NonNull String[] values) {
        stateName = values[0];
        capitalCity = values[1];
        secondCity = values[2];
        thirdCity = values[3];
        statehood = values[4];
        capitalSince = values[5];
        sizeRank = values[6];
    }

    /**
     * Gets the identifier of the stateName-capital row.
     *
     * @return The identifier (id) of the stateName-capital row.
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Sets the identifier of the stateName-capital row.
     *
     * @param id The new identifier (id) to set.
     */
    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name of the stateName associated with the row.
     *
     * @return The name of the stateName.
     */
    @Nullable
    public String getStateName() {
        return stateName;
    }

    /**
     * Sets the name of the stateName associated with the row.
     *
     * @param stateName The new stateName name to set.
     */
    public void setStateName(@Nullable String stateName) {
        this.stateName = stateName;
    }

    /**
     * Gets the capital city of the stateName.
     *
     * @return The capital city of the stateName.
     */
    @Nullable
    public String getCapitalCity() {
        return capitalCity;
    }

    /**
     * Sets the capital city of the stateName.
     *
     * @param capitalCity The new capital city to set.
     */
    public void setCapitalCity(@Nullable String capitalCity) {
        this.capitalCity = capitalCity;
    }

    /**
     * Gets the second-largest city in the stateName.
     *
     * @return The second-largest city in the stateName.
     */
    @Nullable
    public String getSecondCity() {
        return secondCity;
    }

    /**
     * Sets the second-largest city in the stateName.
     *
     * @param secondCity The new second-largest city to set.
     */
    public void setSecondCity(@Nullable String secondCity) {
        this.secondCity = secondCity;
    }

    /**
     * Gets the third-largest city in the stateName.
     *
     * @return The third-largest city in the stateName.
     */
    @Nullable
    public String getThirdCity() {
        return thirdCity;
    }

    /**
     * Sets the third-largest city in the stateName.
     *
     * @param thirdCity The new third-largest city to set.
     */
    public void setThirdCity(@Nullable String thirdCity) {
        this.thirdCity = thirdCity;
    }

    /**
     * Gets the statehood date of the stateName.
     *
     * @return The statehood date of the stateName.
     */
    @Nullable
    public String getStatehood() {
        return statehood;
    }

    /**
     * Sets the statehood date of the stateName.
     *
     * @param statehood The new statehood date to set.
     */
    public void setStatehood(@Nullable String statehood) {
        this.statehood = statehood;
    }

    /**
     * Gets the year in which the stateName's capital was established.
     *
     * @return The year in which the stateName's capital was established.
     */
    @Nullable
    public String getCapitalSince() {
        return capitalSince;
    }

    /**
     * Sets the year in which the stateName's capital was established.
     *
     * @param capitalSince The new year of the stateName's capital establishment to set.
     */
    public void setCapitalSince(@Nullable String capitalSince) {
        this.capitalSince = capitalSince;
    }

    /**
     * Gets the size rank of the stateName among all U.S. states.
     *
     * @return The size rank of the stateName.
     */
    @Nullable
    public String getSizeRank() {
        return sizeRank;
    }

    /**
     * Sets the size rank of the stateName among all U.S. states.
     *
     * @param sizeRank The new size rank of the stateName to set.
     */
    public void setSizeRank(@Nullable String sizeRank) {
        this.sizeRank = sizeRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                stateName,
                capitalCity,
                secondCity,
                thirdCity,
                statehood,
                capitalSince,
                sizeRank);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof StateModel that &&
                id == that.id &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(capitalCity, that.capitalCity) &&
                Objects.equals(secondCity, that.secondCity) &&
                Objects.equals(thirdCity, that.thirdCity) &&
                Objects.equals(statehood, that.statehood) &&
                Objects.equals(capitalSince, that.capitalSince) &&
                Objects.equals(sizeRank, that.sizeRank);
    }

    @NonNull
    @Override
    public String toString() {
        return "StateModel{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", secondCity='" + secondCity + '\'' +
                ", thirdCity='" + thirdCity + '\'' +
                ", statehood='" + statehood + '\'' +
                ", capitalSince='" + capitalSince + '\'' +
                ", sizeRank='" + sizeRank + '\'' +
                '}';
    }
}
