package Oving11;

/**
 * Interface for a specified {@link Property} in the Municipality of Gloppen.<br><br><br>
 *
 * {@code MN_START} - Spesifies a bottom limit for the valid Municipality numbers in Gloppen. This value is constant<br>
 * {@code MN_END} - Spesifies an upper limit for the valid Municipality numbers in Gloppen. This value is constant<br><br>
 * {@link GloppenProperty#checkValidMunicipality(int num) checkValidMunicipality()} - A soon-to-be method for MunicipalityValidation.
 */
public interface GloppenProperty {
    int MN_START = 101;
    int MN_END = 5054;

    /**
     *{@code checkValidMunicipality()} -  A soon-to-be method for MunicipalityValidation. The method takes in parameter
     * which is supposed to represents the Municipality number that is being checked. <br>
     * @param num Supposed to represents the Municipality number that is being checked.
     * @return Type boolean. This method checks if the given municipality number is valid.
     */
    boolean checkValidMunicipality(int num);
}
