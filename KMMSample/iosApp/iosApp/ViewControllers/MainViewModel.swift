//
//  MainViewModel.swift
//  iosApp
//
//  Created by Mohammed Hanif on 05/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class MainViewModel {
    
    // MARK: - Variables
    var apiCallback: ((_ movies: NSMutableArray?, _ error: CustomException?) -> Void)?
    
    /// Get Movies data from Api
    func getMovies() {
        BaseApiClass().getMovies { (succes, error) in
            if error != nil {
                return
            }
            succes?.fold(failed: { (exception) in
                self.apiCallback?(nil, exception)
            }, succeeded: { (popularMovies) -> Any? in
                self.apiCallback?(popularMovies?.results, nil)
                return nil
            })
        }
    }
    
}
