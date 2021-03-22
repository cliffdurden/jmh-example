/*
 * Copyright 2021 the jmh-gradle-example contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.github.cliffdurden.jmh.example.example;

import com.github.cliffdurden.jmh.example.StringConcatenation;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
public class StringConcatenationBenchmarks {


    @Param({"0", "1"})
    public String p;

    @Benchmark
    public void measureAdd(Blackhole bh) {
        String s = StringConcatenation.stringAdd(p);
        bh.consume(s);
    }

    @Benchmark
    public void measureFormat(Blackhole bh) {
        String s = StringConcatenation.stringFormat(p);
        bh.consume(s);
    }

    @Benchmark
    public void measureConcat(Blackhole bh) {
        String s = StringConcatenation.stringConcat(p);
        bh.consume(s);
    }
}
