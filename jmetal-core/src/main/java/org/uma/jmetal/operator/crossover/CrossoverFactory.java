//  CrossoverFactory.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
//
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.uma.jmetal.operator.crossover;

import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.JMetalLogger;

import java.util.HashMap;

/**
 * Class implementing a factory for crossover operator.
 */
public class CrossoverFactory {

  /**
   * Gets a crossover operator through its name.
   *
   * @param name Name of the operator
   * @return The operator
   */
  public static Crossover getCrossoverOperator(String name, HashMap<String, Object> parameters)
    throws JMetalException {
    if ("SBXCrossover".equalsIgnoreCase(name)) {
      return new SBXCrossover(parameters);
    } else if ("SinglePointCrossover".equalsIgnoreCase(name)) {
      return new SinglePointCrossover(parameters);
    } else if ("PMXCrossover".equalsIgnoreCase(name)) {
      return new PMXCrossover(parameters);
    } else if ("TwoPointsCrossover".equalsIgnoreCase(name)) {
      return new TwoPointsCrossover(parameters);
    } else if ("HUXCrossover".equalsIgnoreCase(name)) {
      return new HUXCrossover(parameters);
    } else if ("DifferentialEvolutionCrossover".equalsIgnoreCase(name)) {
      return new DifferentialEvolutionCrossover(parameters);
    } else if ("BLXAlphaCrossover".equalsIgnoreCase(name)) {
      return new BLXAlphaCrossover(parameters);
    } else {
      JMetalLogger.logger.severe("CrossoverFactory.getCrossoverOperator. " +
        "Operator '" + name + "' not found ");
      throw new JMetalException("Exception in " + name + ".getCrossoverOperator()");
    }
  }
}
