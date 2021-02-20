//
//  MainViewController.swift
//  iosApp
//
//  Created by Mohammed Hanifbiji on 22/01/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class MainViewController: UIViewController {
    
    // MARK: - Outlets
    @IBOutlet weak var tblViewMovies: UITableView!
    
    // MARK: - UIViewController Life Cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
}

// MARK: - UITableViewDataSource
extension MainViewController: UITableViewDataSource {
    
    /// Use this to set number od rows we want in our tableView
    /// - Parameters:
    ///   - tableView: UITableView
    ///   - section: TableView Section
    /// - Returns: Count of rows present
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // TODO: Api call
        return 15
    }
    
    /// Use this to set data in tableView Cell
    /// - Parameters:
    ///   - tableView: UITableView
    ///   - indexPath: indexpath
    /// - Returns: Returns our custom cell or UITableViewCell itself
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // TODO: Api call
        guard let tableViewCell = tableView.dequeueReusableCell(withIdentifier: ConstantStrings.movieCell, for: indexPath) as? MoviesCell else {
            return UITableViewCell()
        }
        return tableViewCell
    }
    
}
