/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticmusic.fitness;

import geneticmusic.genes.Note;
import geneticmusic.genes.Pitch;
import org.jgap.Gene;
import org.jgap.IChromosome;

/**
 *
 * @author daviden
 */
public class PausesAfterShortNotes implements CompositionRule{

    @Override
    public double evaluate(IChromosome ic) {
        double result = 0.0;
         Gene [] genes = ic.getGenes();
         for (int i = 0; i < genes.length - 1; i++) {
            Note currentNote = (Note) genes[i].getAllele();
            Note nextNote = (Note) genes[i + 1].getAllele();
            
            if(nextNote.getPitch().equals(Pitch.R) &&
               !currentNote.getPitch().equals(Pitch.R) &&
                    currentNote.getDuration() > 8)
                result = -10.0;
         }
         return result;
    }

    public String getName() {
        return "Pauses After Short Notes Rule";
    }
}
